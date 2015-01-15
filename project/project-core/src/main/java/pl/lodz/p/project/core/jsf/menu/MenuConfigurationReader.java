package pl.lodz.p.project.core.jsf.menu;

import org.springframework.context.annotation.Scope;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milczu
 */
@Named
@Scope("request")
public class MenuConfigurationReader implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Document document;

    public MenuConfigurationReader(String configPath) {
        InputStream inputStream = null;
        try {
            inputStream = getClass().getResourceAsStream(configPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(inputStream);

            document.getDocumentElement().normalize();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new ConfugurationReaderException("Unable to parse menu configuration", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuConfigurationReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<MenuItem> readConfiguration() {
        if (document == null) {
            return new ArrayList<>();
        }
        NodeList menuItemNodes = document.getElementsByTagName("menu").item(0).getChildNodes();
        return readMenuItems(menuItemNodes);
    }

    private List<MenuItem> readMenuItems(NodeList menuItemNodes) {
        List<MenuItem> menuItems = new ArrayList<>();
        for (int i = 0; i < menuItemNodes.getLength(); i++) {
            Node menuItemNode = menuItemNodes.item(i);
            if ("menu-item".equals(menuItemNode.getNodeName())) {
                Element menuItemElement = (Element) menuItemNode;
                MenuItem menuItem = new MenuItem();

                menuItem.setName(menuItemElement.getAttribute("name"));
                if (menuItemElement.hasAttribute("styleClass")) {
                    menuItem.setStyleClass(menuItemElement.getAttribute("styleClass"));
                }

                if (menuItemElement.hasAttribute("hasAnyRole")) {
                    String[] roles = menuItemElement.getAttribute("hasAnyRole").split(",");
                    boolean result = false;
                    for (String role : roles) {
                        if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role.trim())) {
                            result = true;
                            break;
                        }
                    }
                    menuItem.setRendered(result);
                } else {
                    menuItem.setRendered(true);
                }

                NodeList childrenMenuItemsNodeList = menuItemElement.getElementsByTagName("menu-item");
                if (childrenMenuItemsNodeList.getLength() > 0) {
                    List<MenuItem> childrenMenuItems = readMenuItems(childrenMenuItemsNodeList);
                    menuItem.setMenuItems(childrenMenuItems);
                } else {
                    String targetUrl = menuItemElement.getAttribute("targetUrl");
                    menuItem.setTargetUrl(targetUrl);
                }
                if (menuItemElement.getElementsByTagName("activeDefinitions").getLength() == 0) {
                    MenuActiveDefinition menuActiveDefinition = new MenuActiveDefinition(menuItem.getTargetUrl(), StringCompareOperation.EQUALS);
                    menuItem.setActiveDefinitions(Collections.singletonList(menuActiveDefinition));
                } else {
                    Element activeDefinitionsElement = (Element) menuItemElement.getElementsByTagName("activeDefinitions").item(0);
                    List<MenuActiveDefinition> menuActiveDefinitions = readActiveDefinitions(activeDefinitionsElement);
                    menuItem.setActiveDefinitions(menuActiveDefinitions);
                }

                menuItems.add(menuItem);
            }

        }
        return menuItems;
    }

    private List<MenuActiveDefinition> readActiveDefinitions(Element activeDefinitionsElement) {
        NodeList nodeList = activeDefinitionsElement.getElementsByTagName("activeNode");
        if (nodeList.getLength() == 0) {
            return new ArrayList<>();
        } else {
            List<MenuActiveDefinition> menuActiveDefinitions = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element activeNodeElement = (Element) nodeList.item(i);
                String requestPath = activeNodeElement.getAttribute("requestPath");
                StringCompareOperation compare = StringCompareOperation.valueOf(activeNodeElement.getAttribute("compare"));
                MenuActiveDefinition activeDefinition = new MenuActiveDefinition(requestPath, compare);
                menuActiveDefinitions.add(activeDefinition);
            }

            return menuActiveDefinitions;
        }
    }

}
