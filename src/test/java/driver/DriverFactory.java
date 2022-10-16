package driver;

public enum DriverFactory {
	FIREFOX {
		@Override
		public DriverManager getDriverManager() {
			return new FirefoxDriverManager();
		}

	},
	REMOTE_CHROME {
		@Override
		public DriverManager getDriverManager() {
			return new RemoteChromeDriverManager();
		}

	},
	CHROME {
		@Override
		public DriverManager getDriverManager() {
			return new ChromeDriverManager();
		}
		
	};
	
	public abstract DriverManager getDriverManager();
}
