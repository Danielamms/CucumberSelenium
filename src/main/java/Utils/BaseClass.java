package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			initializeDriver();
		}
		return driver;
	}

	public static void initializeDriver() {
		// 1) Preparar o ChromeOptions
		ChromeOptions options = new ChromeOptions();

		// 2) Desabilitar o Gerenciador de Senhas (Password Manager)
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);         // Desabilita o serviço de credenciais
		prefs.put("profile.password_manager_enabled", false);   // Desabilita o pop-up de salvar senha

		// 3) Desabilitar a detecção de senhas vazadas (Password Leak Detection)
		//    A flag abaixo evita que o Chrome exiba o alerta “Mude sua senha” caso a senha esteja comprometida.
		options.addArguments("--disable-features=PasswordLeakDetection");
		options.addArguments("--disable-features=PasswordCheck");

		options.setExperimentalOption("prefs", prefs);

		// 4) Qualquer outra opção que você já utiliza (por exemplo, rodar em modo headless, se necessário)
		// options.addArguments("--headless");
		// options.addArguments("--window-size=1920,1080");

		// 5) Criar o ChromeDriver passando as opções
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		// 6) Configurar timeouts e maximizar janela
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
