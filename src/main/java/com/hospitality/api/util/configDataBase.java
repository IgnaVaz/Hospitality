package com.hospitality.api.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class configDataBase {

	
	@Primary
	@Bean(name = "Hospitality")
    public DataSource getDataSourceHospitality() {
     
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://kleverhospitality.cvei5icxuveh.us-east-1.rds.amazonaws.com:6345/Hospitality?currentSchema='public'");
        dataSourceBuilder.username("rIEwoRTE");
        dataSourceBuilder.password("UsKTMS&Jj25^");
        return dataSourceBuilder.build();
    }

}
