package org.xiaofei.cloudscal;


import com.woorea.openstack.base.client.OpenStackSimpleTokenProvider;
import com.woorea.openstack.keystone.Keystone;
import com.woorea.openstack.keystone.model.Tenant;

public class ExamplesConfiguration {

	public static final String KEYSTONE_AUTH_URL = "http://10.10.19.254:5000/v2.0";
	
	public static final String KEYSTONE_USERNAME = "admin";
	
	public static final String KEYSTONE_PASSWORD = "sbsmsbsm";
	
	public static final String KEYSTONE_ENDPOINT = "http://10.10.19.254:5000/v2.0";
	
	public static final String TENANT_NAME = "demo";

	public static final String NOVA_ENDPOINT = "http://10.10.19.254:8774/v2";
	
	public static final String CEILOMETER_ENDPOINT = "";
	
	public static void main(String[] args) {
		Keystone client = new Keystone(KEYSTONE_ENDPOINT);
		client.setTokenProvider(new OpenStackSimpleTokenProvider("secret0"));
		client.tenants().delete("36c481aec1d54fc49190c92c3ef6840a").execute();
		Tenant tenant = client.tenants().create(new Tenant("new_api")).execute();
		System.out.println(tenant);
		System.out.println(client.tenants().list().execute());
		client.tenants().delete(tenant.getId()).execute();
	}
	
}
