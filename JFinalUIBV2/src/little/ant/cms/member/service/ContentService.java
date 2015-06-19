package little.ant.cms.member.service;

import com.jfinal.aop.Enhancer;
import com.jfinal.plugin.activerecord.tx.Tx;

import little.ant.platform.service.BaseService;

import org.apache.log4j.Logger;

public class ContentService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(ContentService.class);
	
	public static final ContentService service = Enhancer.enhance(ContentService.class, Tx.class);
	
}
