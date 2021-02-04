import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    public AppConfig() {
    }
@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{Beans.class};
    }
@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }
@Override
    protected String[] getServletMappings() {
        return new String[]{"*.com"};
    }
}
