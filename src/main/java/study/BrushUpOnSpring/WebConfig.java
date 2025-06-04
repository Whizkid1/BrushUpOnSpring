package study.BrushUpOnSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.BrushUpOnSpring.converter.IntegerToStringConverter;
import study.BrushUpOnSpring.converter.IpPortToStringConverter;
import study.BrushUpOnSpring.converter.StringToIntegerConverter;
import study.BrushUpOnSpring.converter.StringToIpPortConverter;
import study.BrushUpOnSpring.formatter.MyNumberFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        //추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
