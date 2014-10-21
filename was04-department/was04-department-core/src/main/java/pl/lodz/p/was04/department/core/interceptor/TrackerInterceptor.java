package pl.lodz.p.was04.department.core.interceptor;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Responsible for tracking method invocations and logging.
 *
 * @author Łukasz Gadomski
 */
public class TrackerInterceptor implements Serializable {

    //TODO @Resource
    //private SessionContext sctx;
    
	private static final long serialVersionUID = 1L;
	
	private static final Logger loger = Logger.getLogger(TrackerInterceptor.class.getName());

    /**
     * Reads the context of the invoked method and logs information about its name, its component name, calling user
     * identity, arguments passed to the method and the returned value.
     *
     * @param ictx invocation context
     * @return log
     * @throws Exception
     */
    @AroundInvoke
    public Object traceInvoke(InvocationContext ictx) throws Exception {
        String message = "";
        String method = "Intercepted method invocation: method: " + ictx.getMethod();
        String user = " user: ";//TODO + sctx.getCallerPrincipal().getName();
        String parameters = " parameters: ";

        message = message + method + user + parameters;
        if (ictx.getParameters() != null) {
            for (Object param : ictx.getParameters()) {
                if (null == param) {
                    message = message + "null ";
                } else {
                    message = message + param.toString() + " ";
                }
            }
        }
        Object result;
        try {
            result = ictx.proceed();
        } catch (Exception e) {
            message = message + " An exception occured: " + e.toString();
            loger.severe(message);
            throw e;
        }

        message = message + " returned value: ";
        if (null == result) {
            message = message + "null ";
        } else {
            message = message + result.toString() + " ";
        }
        loger.severe(message);

        return result;
    }
}
