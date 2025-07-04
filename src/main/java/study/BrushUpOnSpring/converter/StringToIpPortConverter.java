package study.BrushUpOnSpring.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import study.BrushUpOnSpring.type.IpPort;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {
    @Override
    public IpPort convert(String source) {
        log.info("convert source={}", source);
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip, port);
    }
}
