package webApplication;

import by.lk.configs.WebConfig;
import by.lk.config.RootConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.*;
/**
 * Created by Vinty on 25.06.2017.
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {return new Class[]{RootConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] { characterEncodingFilter};
    }

//@Override
//protected Filter[] getServletFilters() {
//    Filter[] filters;
//    CharacterEncodingFilter encFilter;
//    HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
//    encFilter = new CharacterEncodingFilter();
//    encFilter.setEncoding("UTF-8");
//    encFilter.setForceEncoding(true);
//    filters = new Filter[] {httpMethodFilter, encFilter};
//    return filters;
//}


//    @Override
//    public void onStartup(ServletContext servletContext)
//            throws ServletException {
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//
//        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
//        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", characterEncodingFilter);
//        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
//    }

}
