package com.springtest.springrest.config;

//package com.azure.spring.data.cosmos;
/**
 * WARNING: MODIFYING THIS FILE WILL REQUIRE CORRESPONDING UPDATES TO README.md FILE. LINE NUMBERS
 * ARE USED TO EXTRACT APPROPRIATE CODE SEGMENTS FROM THIS FILE. ADD NEW CODE AT THE BOTTOM TO AVOID CHANGING
 * LINE NUMBERS OF EXISTING CODE SAMPLES.
 */

import com.azure.core.credential.AzureKeyCredential;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.springtest.springrest.dao.CourseDaoInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

@Configuration
@EnableCosmosRepositories(basePackageClasses = CourseDaoInterface.class)
public class AppConfig extends AbstractCosmosConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

	@Value("https://carbon-footprint.documents.azure.com:443/")
	private String uri;

	@Value("vSrylwxCwXvaY5sTOEgQK2UtZgCJYDvT1WBFKw03vV0vv9aBpAxmcmbKfYumv1hK8KafhOmv4wINYO1iFKnI5Q==")
	private String key;

	@Value("O3PFahitr5Otezq5u6PE4V5ntC8PnUSIB49FNQhKz0f3zgGVSFcEy5paWqaO7vNstRbGcw6VDkuM6PVgmiG2sQ==")
	private String secondaryKey;

	@Value("satyam")
	private String dbName;

	@Value("false")
	private boolean queryMetricsEnabled;

	private AzureKeyCredential azureKeyCredential;

	@Bean
	public CosmosClientBuilder getCosmosClientBuilder() {
		this.azureKeyCredential = new AzureKeyCredential(key);
		DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
		GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
		return new CosmosClientBuilder().endpoint(uri).credential(azureKeyCredential).directMode(directConnectionConfig,
				gatewayConnectionConfig);
	}

	@Override
	public CosmosConfig cosmosConfig() {
		return CosmosConfig.builder().enableQueryMetrics(queryMetricsEnabled)
				.responseDiagnosticsProcessor(new ResponseDiagnosticsProcessorImplementation()).build();
	}

	public void switchToSecondaryKey() {
		this.azureKeyCredential.update(secondaryKey);
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	private static class ResponseDiagnosticsProcessorImplementation implements ResponseDiagnosticsProcessor {

		@Override
		public void processResponseDiagnostics(@Nullable ResponseDiagnostics responseDiagnostics) {
			LOGGER.info("Response Diagnostics {}", responseDiagnostics);
		}
	}

}