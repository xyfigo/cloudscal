package org.xiaofei.cloudscal;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.openstack4j.core.transport.HttpMethod;
import org.openstack4j.core.transport.HttpRequest;
import org.openstack4j.openstack.identity.domain.Credentials;
import org.openstack4j.openstack.identity.domain.KeystoneAccess;

public class JerseyRs {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String user="admin";
		String password="sbsmsbsm";
		String tenantName="demo";
		String tenantId="";
		String endpoint="http://10.10.19.254:5000/v2.0";
		/*Credentials credentials = new Credentials(user, password, tenantName, tenantId);
		HttpRequest<KeystoneAccess> request =  HttpRequest.builder(KeystoneAccess.class).endpoint(endpoint).method(HttpMethod.POST).path("/tokens").
				entity(credentials).build();
		Client client = ClientBuilder.newBuilder()
				.register(JacksonFeature.class).build();
		WebTarget target=client.target(request.getEndpoint()).path(request.getPath());
		Invocation.Builder invocation= target.request();
		Entity<?> entity = (request.getEntity() == null) ? null :
			Entity.entity(request.getEntity(), request.getContentType());
		Response response=invocation.method("POST", entity);
		System.out.println(response.toString());*/
		URLConnection ucConnection = new URL("http://10.10.19.254:8777/v2/meters").openConnection();
		//ucConnection.setDoOutput(true);
		
		//PrintWriter pw = new PrintWriter(ucConnection.getOutputStream());
		String token="MIIRXwYJKoZIhvcNAQcCoIIRUDCCEUwCAQExDTALBglghkgBZQMEAgEwgg+tBgkqhkiG9w0BBwGggg+eBIIPmnsiYWNjZXNzIjogeyJ0b2tlbiI6IHsiaXNzdWVkX2F0IjogIjIwMTQtMDctMDdUMTQ6NDU6MDEuNDcxMjAyIiwgImV4cGlyZXMiOiAiMjAxNC0wNy0wN1QxNTo0NTowMVoiLCAiaWQiOiAicGxhY2Vob2xkZXIiLCAidGVuYW50IjogeyJkZXNjcmlwdGlvbiI6IG51bGwsICJlbmFibGVkIjogdHJ1ZSwgImlkIjogImM1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgIm5hbWUiOiAiZGVtbyJ9fSwgInNlcnZpY2VDYXRhbG9nIjogW3siZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc0L3YyL2M1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc0L3YyL2M1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgImlkIjogIjAxMTZlNWQ5MjRiOTQxYjA5ODdiOGI4NjY2ZGZiYzI3IiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0Ojg3NzQvdjIvYzU3MDMyYWNmOWI2NDgyODg5YTQyYWI3ZWI1NjdiOWQifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAiY29tcHV0ZSIsICJuYW1lIjogIm5vdmEifSwgeyJlbmRwb2ludHMiOiBbeyJhZG1pblVSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0Ojg3NzYvdjIvYzU3MDMyYWNmOWI2NDgyODg5YTQyYWI3ZWI1NjdiOWQiLCAicmVnaW9uIjogIlJlZ2lvbk9uZSIsICJpbnRlcm5hbFVSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0Ojg3NzYvdjIvYzU3MDMyYWNmOWI2NDgyODg5YTQyYWI3ZWI1NjdiOWQiLCAiaWQiOiAiMjFmM2FhNTE2MmQ3NDY2YjkyMjhmYWE3YWM2NzYyMWUiLCAicHVibGljVVJMIjogImh0dHA6Ly8xMC4xMC4xOS4yNTQ6ODc3Ni92Mi9jNTcwMzJhY2Y5YjY0ODI4ODlhNDJhYjdlYjU2N2I5ZCJ9XSwgImVuZHBvaW50c19saW5rcyI6IFtdLCAidHlwZSI6ICJ2b2x1bWV2MiIsICJuYW1lIjogImNpbmRlcnYyIn0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc0L3YzIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc0L3YzIiwgImlkIjogIjdjMjJhZjRkYTdkMTQxYTc4OWZlMWFiZmY1ZDA4ZDMwIiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0Ojg3NzQvdjMifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAiY29tcHV0ZXYzIiwgIm5hbWUiOiAibm92YXYzIn0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDozMzMzIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDozMzMzIiwgImlkIjogIjI3NDY4Njk5MGY0MzQxNGRhNzhjZGNhMTUzMmQ1NTA0IiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0OjMzMzMifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAiczMiLCAibmFtZSI6ICJzMyJ9LCB7ImVuZHBvaW50cyI6IFt7ImFkbWluVVJMIjogImh0dHA6Ly8xMC4xMC4xOS4yNTQ6OTI5MiIsICJyZWdpb24iOiAiUmVnaW9uT25lIiwgImludGVybmFsVVJMIjogImh0dHA6Ly8xMC4xMC4xOS4yNTQ6OTI5MiIsICJpZCI6ICIzZGY4YWQwNjkyMzg0NTAwODM4ZWVkMGQzZmNiMjFiNSIsICJwdWJsaWNVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo5MjkyIn1dLCAiZW5kcG9pbnRzX2xpbmtzIjogW10sICJ0eXBlIjogImltYWdlIiwgIm5hbWUiOiAiZ2xhbmNlIn0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc3LyIsICJyZWdpb24iOiAiUmVnaW9uT25lIiwgImludGVybmFsVVJMIjogImh0dHA6Ly8xMC4xMC4xOS4yNTQ6ODc3Ny8iLCAiaWQiOiAiMGUyNzZjZTgzODY0NDE0NGE0ODA1YzllNWYwMTczZmMiLCAicHVibGljVVJMIjogImh0dHA6Ly8xMC4xMC4xOS4yNTQ6ODc3Ny8ifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAibWV0ZXJpbmciLCAibmFtZSI6ICJjZWlsb21ldGVyIn0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4MDAwL3YxIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4MDAwL3YxIiwgImlkIjogIjFkM2M3MDgyNWU5OTQwOTE4NjFjZDQyYWVhYjdmNzk2IiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0OjgwMDAvdjEifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAiY2xvdWRmb3JtYXRpb24iLCAibmFtZSI6ICJoZWF0In0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc2L3YxL2M1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4Nzc2L3YxL2M1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgImlkIjogIjI4NWRiNGExMmRmMjQwMDk5MzgyOGMzMmQxYmJlNTBjIiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0Ojg3NzYvdjEvYzU3MDMyYWNmOWI2NDgyODg5YTQyYWI3ZWI1NjdiOWQifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAidm9sdW1lIiwgIm5hbWUiOiAiY2luZGVyIn0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4NzczL3NlcnZpY2VzL0FkbWluIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4NzczL3NlcnZpY2VzL0Nsb3VkIiwgImlkIjogIjEwOGEzODQ4MzI3MzQxNzk5MWE2YmRjYzBhN2VkODhiIiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0Ojg3NzMvc2VydmljZXMvQ2xvdWQifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAiZWMyIiwgIm5hbWUiOiAiZWMyIn0sIHsiZW5kcG9pbnRzIjogW3siYWRtaW5VUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4MDA0L3YxL2M1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgInJlZ2lvbiI6ICJSZWdpb25PbmUiLCAiaW50ZXJuYWxVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo4MDA0L3YxL2M1NzAzMmFjZjliNjQ4Mjg4OWE0MmFiN2ViNTY3YjlkIiwgImlkIjogIjE1MTA4MmViZWZlMjQ2ZWJiZjQ4ZTk3MTI2ZmFhZjAwIiwgInB1YmxpY1VSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0OjgwMDQvdjEvYzU3MDMyYWNmOWI2NDgyODg5YTQyYWI3ZWI1NjdiOWQifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAib3JjaGVzdHJhdGlvbiIsICJuYW1lIjogImhlYXQifSwgeyJlbmRwb2ludHMiOiBbeyJhZG1pblVSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0OjM1MzU3L3YyLjAiLCAicmVnaW9uIjogIlJlZ2lvbk9uZSIsICJpbnRlcm5hbFVSTCI6ICJodHRwOi8vMTAuMTAuMTkuMjU0OjUwMDAvdjIuMCIsICJpZCI6ICIzZGM5NzE3MTBkZjA0ODhiYTg2M2VjYTBkZTYxYTMwNCIsICJwdWJsaWNVUkwiOiAiaHR0cDovLzEwLjEwLjE5LjI1NDo1MDAwL3YyLjAifV0sICJlbmRwb2ludHNfbGlua3MiOiBbXSwgInR5cGUiOiAiaWRlbnRpdHkiLCAibmFtZSI6ICJrZXlzdG9uZSJ9XSwgInVzZXIiOiB7InVzZXJuYW1lIjogImFkbWluIiwgInJvbGVzX2xpbmtzIjogW10sICJpZCI6ICI2ZDlkNDdmZGZhMzc0YTM3YjJhMDNiZGE1ODk0MDA4NiIsICJyb2xlcyI6IFt7Im5hbWUiOiAiYWRtaW4ifSwgeyJuYW1lIjogImhlYXRfc3RhY2tfb3duZXIifV0sICJuYW1lIjogImFkbWluIn0sICJtZXRhZGF0YSI6IHsiaXNfYWRtaW4iOiAwLCAicm9sZXMiOiBbImU5YzdkMTA2YmU4MDQ2NzU4M2RhN2RhMzBkMGY3ZGYyIiwgIjA0NTc1NDE5MzM3MTRiNjhiYWIwNzEwM2FlMGQ5OWJkIl19fX0xggGFMIIBgQIBATBcMFcxCzAJBgNVBAYTAlVTMQ4wDAYDVQQIDAVVbnNldDEOMAwGA1UEBwwFVW5zZXQxDjAMBgNVBAoMBVVuc2V0MRgwFgYDVQQDDA93d3cuZXhhbXBsZS5jb20CAQEwCwYJYIZIAWUDBAIBMA0GCSqGSIb3DQEBAQUABIIBAIujz3I0y5hsDV6WLGdxBjPSgSsXqRpYR51qyRT1tTpgas2M2xJyLFPjSNIf7geD77kQDuFXXsjpmojUn6bCq6vegsDD02jkgCCIbp7jIPmJIKTP0pCPVUQ-cYHzivX+RB9ptnWuyVkhZcnpcAuHkFLB9D690-M4wKsNDF0QkA165k1XUJPr8QyXX8nMrM8t1kGQrJjKr419GS2l4Tc1OZG-40txSALqQAwGYgKFAZs-+eVnudpAWg3xr70Cywrb4RUYI5mYxdIcD98n6mnnLOsfH8lQbK0+oHScxC10ZMBJG8ZVvywrIoiXwX7MVdWmxY4JpH6FKicA6cst1eOMjvM=";
		//pw.print("X-Auth-Token"+'='+token);
		
		//pw.close();
		ucConnection.setRequestProperty("X-Auth-Token", token);
		//ucConnection.setRequestProperty("Accept", "application/json");
		
		Scanner in = null;
		StringBuilder response =new StringBuilder();
		try {
			in=new Scanner(ucConnection.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
			if(!(ucConnection instanceof HttpURLConnection)) throw e;
			InputStream errInputStream=((HttpURLConnection) ucConnection).getErrorStream();
			if(errInputStream==null) throw e;
			in=new Scanner(errInputStream);
		}
		while(in.hasNext())
		{
			response.append(in.nextLine());
			response.append("\n");
		}
		
		in.close();
		System.out.print(response);
		
		

	}

}
