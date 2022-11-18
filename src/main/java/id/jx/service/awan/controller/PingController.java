package id.jx.service.awan.controller;

import id.jx.service.awan.config.MyServiceConfig;
import id.jx.service.awan.enums.ResponseCode;
import id.jx.service.awan.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PingController {
	private final MyServiceConfig myServiceConfig;

	@GetMapping("/ping")
	public Map<String, Object> healthCheck() {
		log.debug("Ping!");
		Map<String, Object> map = new HashMap<>();
		map.put("status", myServiceConfig.getAppName() + " is UP");

		return map;
	}

	@GetMapping("/pong")
	public ApiResponse<String> checkHealth() {
		log.debug("Pong!");
		String str = myServiceConfig.getAppName() + " is UP";
		return new ApiResponse<>(true, ResponseCode.SUCCESS.getCode(), str, ResponseCode.SUCCESS.getMessage());
	}
}
