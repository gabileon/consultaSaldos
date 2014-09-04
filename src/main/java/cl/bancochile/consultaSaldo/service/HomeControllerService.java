package cl.bancochile.consultaSaldo.service;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.BindingProvider;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.bancochile.osb.tarjetacreditos.consultarsaldos.ConsultarSaldos;
import cl.bancochile.osb.tarjetacreditos.consultarsaldos.ConsultarSaldosRequest;
import cl.bancochile.osb.tarjetacreditos.consultarsaldos.ConsultarSaldosResponse;
import cl.bancochile.osb.tarjetacreditos.consultarsaldosrequest.CuerpoType;
import cl.bancochile.osb.tarjetacreditos.consultarsaldosrequest.ReqConsultarSaldosType;
import cl.bancochile.osb.tarjetacreditos.consultarsaldosresponse.DatosTarjetaAutorizadorType;


@Service
public class HomeControllerService {
	
	@Resource(name="saldoTCWSProxy")
	private ConsultarSaldos saldoTCWSProxy ;

	public Map obtenerInformacionServicioFichaChica(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String,String> obtenerInformacionTC(String numeroTarjeta) {
        
		
		CuerpoType cuerpoType = new CuerpoType();
		ConsultarSaldosRequest csr = new ConsultarSaldosRequest();
		ReqConsultarSaldosType req = new ReqConsultarSaldosType();
		cuerpoType.setNumeroTarjeta(numeroTarjeta);
		cuerpoType.setSecuenciaTarjeta(1);
		req.setCuerpo(cuerpoType);
		csr.setReqConsultarSaldos(req);
	
		((BindingProvider)saldoTCWSProxy).getRequestContext().put("rutConDV", "1-9");
		ConsultarSaldosResponse consul = saldoTCWSProxy.consultarSaldos(csr);
		System.out.println("test:" + consul.getRespConsultarSaldos().getCuerpo().getDatosTarjeta().getCupoAvancesNacional());
//		
////		return "{resultado:ok}";
//	} catch(Exception e) {
//		logger.error("Error al invocar servicio", e);
//		return "{resultado:nok}";
//	}
	
		System.out.println(consul.getRespConsultarSaldos().getCuerpo().getDatosTarjetaAutorizador());
        return crearJSONRef(consul.getRespConsultarSaldos().getCuerpo());
    }

	private Map <String,String> crearJSONRef(cl.bancochile.osb.tarjetacreditos.consultarsaldosresponse.CuerpoType cuerpoType) {
		Map<String, String>  mapa = new HashMap<String, String>();
		mapa.put("cupoComprasNacional", cuerpoType.getDatosTarjetaAutorizador().getCupoComprasNacional().toString());
		System.out.println("test:" + cuerpoType.getDatosTarjeta().getCupoAvancesNacional());
//		mapa.put("cupoComprasInternacional", c.getCupoComprasInternacional().toString());
//		mapa.put("cupoAvancesNacional", c.getCupoAvancesNacional().toString());
//		mapa.put("cupoAvancesInternacional", c.getCupoAvancesInternacional().toString());
//		mapa.put("deudaComprasNacional", c.getDeudaComprasNacional().toString());
//		mapa.put("deudaComprasInternacional", c.getDeudaComprasInternacional().toString());
//		mapa.put("deudaAvancesNacional", c.getDeudaAvancesNacional().toString());
//		mapa.put("deudaAvancesInternacional", c.getDeudaAvancesInternacional().toString());
////		mapa.put("disponibleComprasNacional", c.getCupoComprasNacional().toString());
////		mapa.put("disponibleComprasInternacional", c.getCupoComprasNacional().toString());
////		mapa.put("disponibleAvancesNacional", c.getCupoComprasNacional().toString());
////		mapa.put("disponibleAvancesInternacional", c.getCupoComprasNacional().toString());
//	//	
        return mapa;
    }
	



}






