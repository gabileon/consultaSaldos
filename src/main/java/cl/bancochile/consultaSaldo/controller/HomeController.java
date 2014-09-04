package cl.bancochile.consultaSaldo.controller;


import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.bancochile.consultaSaldo.service.HomeControllerService;
import cl.bancochile.osb.tarjetacreditos.consultarsaldos.ConsultarSaldos;
import cl.bancochile.osb.tarjetacreditos.consultarsaldos.ConsultarSaldosRequest;
import cl.bancochile.osb.tarjetacreditos.consultarsaldos.ConsultarSaldosResponse;
import cl.bancochile.osb.tarjetacreditos.consultarsaldosrequest.CuerpoType;
import cl.bancochile.osb.tarjetacreditos.consultarsaldosrequest.ReqConsultarSaldosType;
import cl.bancochile.osb.tarjetacreditos.consultarsaldosresponse.DatosTarjetaAutorizadorType;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private HomeControllerService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home",  method={RequestMethod.POST,RequestMethod.GET})
	
	 public @ResponseBody Map<String,String> home(//@ModelAttribute("cuenta")Cuenta cuenta, 
	            String numeroTarjeta)
	            { 

//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//			
//		CuerpoType cuerpoType = new CuerpoType();
//		ConsultarSaldosRequest csr = new ConsultarSaldosRequest();
//		ReqConsultarSaldosType req = new ReqConsultarSaldosType();
//		cuerpoType.setNumeroTarjeta("4152822090000204");
//		cuerpoType.setSecuenciaTarjeta(1);
//		req.setCuerpo(cuerpoType);
//		csr.setReqConsultarSaldos(req);
//		
//			((BindingProvider)saldoTCWSProxy).getRequestContext().put("rutConDV", "1-9");
//			ConsultarSaldosResponse consul = saldoTCWSProxy.consultarSaldos(csr);
//			
//			return crearJSON(consul.getRespConsultarSaldos().getCuerpo().getDatosTarjetaAutorizador());
//		} catch(Exception e) {
//			logger.error("Error al invocar servicio", e);
//			Map<String,String> map = new HashMap<String,String>();
//			map.put("error", "1");
//			return map;
//		}
//		

//			service.obtenerInformacionTC(numeroTarjeta);
		return service.obtenerInformacionTC(numeroTarjeta);
	}
	
	 
    @RequestMapping(value="/", method=RequestMethod.GET)
	 public String index()
	    {
	        return "index";
	    }


}
//	
//	@RequestMapping(value = "/home2",  method={RequestMethod.POST,RequestMethod.GET})
//	
//	 public @ResponseBody String home2(Locale locale, Model model) {
//		try {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//			
//		CuerpoType cuerpoType = new CuerpoType();
//		ConsultarSaldosRequest csr = new ConsultarSaldosRequest();
//		ReqConsultarSaldosType req = new ReqConsultarSaldosType();
//		cuerpoType.setNumeroTarjeta("4152822090000204");
//		cuerpoType.setSecuenciaTarjeta(1);
//		req.setCuerpo(cuerpoType);
//		csr.setReqConsultarSaldos(req);
//		
//			((BindingProvider)saldoTCWSProxy).getRequestContext().put("rutConDV", "1-9");
//			ConsultarSaldosResponse consul = saldoTCWSProxy.consultarSaldos(csr);
//			logger.info("test:" + consul.getRespConsultarSaldos().getCuerpo().getDatosTarjeta().getCupoAvancesNacional());
//			
//			return "{resultado:ok}";
//		} catch(Exception e) {
//			logger.error("Error al invocar servicio", e);
//			return "{resultado:nok}";
//		}
//		
//	}
//
//	private Map<String, String> crearJSON(DatosTarjetaAutorizadorType c)
//	{
//		Map<String, String>  mapa = new HashMap<String, String>();
//		mapa.put("cupoComprasNacional", c.getCupoComprasNacional().toString());
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
////		
//		
//	return mapa;
//	}
//
//	
//}
//
//







