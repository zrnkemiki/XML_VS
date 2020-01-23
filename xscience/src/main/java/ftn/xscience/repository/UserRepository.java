package ftn.xscience.repository;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import ftn.xscience.model.ObjectFactory;
import ftn.xscience.model.TUser;
import ftn.xscience.utils.xmldb.BasicXMLConnectionPool;
import ftn.xscience.utils.xmldb.DBHandler;
import ftn.xscience.utils.xmldb.XMLConnectionProperties;

@Repository
public class UserRepository {

	@Autowired
	BasicXMLConnectionPool connectionPool;
	
	private static String collectionId = "/db/data/users";
	
	
	public TUser getUserByEmail(String email) throws JAXBException {
		String newStr = "user-" + email.toLowerCase() + ".xml";
		String documentId = newStr.replaceAll("\\@", "-");
		documentId = documentId.replace("-com", ".com");
		System.out.println(documentId);
		XMLConnectionProperties conn = connectionPool.getConnection();
		TUser user = null;
		
		try {
			XMLResource res = DBHandler.getDocument(collectionId, documentId, conn);
			user = unmarshal(res);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionPool.releaseConnection(conn);
		}

		return user;
	}
	
	
	public String marshal(TUser user) throws JAXBException {
		OutputStream os = new ByteArrayOutputStream();
		JAXBContext context = JAXBContext.newInstance("ftn.xscience.model");
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		ObjectFactory fac = new ObjectFactory();
		JAXBElement<TUser> jaxbUser = fac.createUser(user);
        marshaller.marshal(jaxbUser, os);

        return os.toString();

	}
	
	public TUser unmarshal(XMLResource resource) throws JAXBException, XMLDBException {
		JAXBContext context = JAXBContext.newInstance("ftn.xscience.model");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		TUser user = (TUser) JAXBIntrospector.getValue(unmarshaller.unmarshal(resource.getContentAsDOM()));
		return user;
	}
}
