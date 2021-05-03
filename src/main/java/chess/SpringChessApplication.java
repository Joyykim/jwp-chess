package chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SpringChessApplication {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	private static final Logger fileLogger = LoggerFactory.getLogger("file");

	public static void main(String[] args) {
		SpringApplication.run(SpringChessApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		log.error("An ERROR Message");
		fileLogger.info("파일 로깅 입니다.");
		return "index";
	}
}
