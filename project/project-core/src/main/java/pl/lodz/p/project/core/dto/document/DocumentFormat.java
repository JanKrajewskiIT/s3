package pl.lodz.p.project.core.dto.document;

import com.google.common.collect.Lists;

import java.util.List;

import org.springframework.util.Assert;

/**
 *
 * @author Milczu
 */
public class DocumentFormat {
    
    public enum DocumentFormatItem {
        NR, PREFIKS, MM, RRRR
    }
    
    private static final List<String> AVAILABLE_FORMATS = Lists.newArrayList("NR/RRRR", "NR/MM/RRRR", "PREFIKS/NR/RRRR", "PREFIKS/NR/MM/RRRR");
    private static final String DEFAULT_FORMAT = "PREFIKS/NR/RRRR";
    
    private final String pattern;
    private final boolean prefix;
    private final boolean month;
    
    public static DocumentFormat forPattern(String pattern) {
        Assert.isTrue(AVAILABLE_FORMATS.contains(pattern), "Pattern: " + pattern + " not match for available formats: " + AVAILABLE_FORMATS);
        return new DocumentFormat(pattern);
    }
    
    protected DocumentFormat(String pattern) {
        this.pattern = pattern;
        this.prefix = pattern.contains("PREFIKS");
        this.month = pattern.contains("MM");
    }

    public String getPattern() {
        return pattern;
    }

    public boolean isPrefix() {
        return prefix;
    }

    public boolean isMonth() {
        return month;
    }

    public static List<String> availableFormats() {
        return AVAILABLE_FORMATS;
    }
    
    public static String defaultFormat() {
        return DEFAULT_FORMAT;
    }
       
}
