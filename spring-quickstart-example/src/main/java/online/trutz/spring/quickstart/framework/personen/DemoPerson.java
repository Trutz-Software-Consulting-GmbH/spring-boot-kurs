package online.trutz.spring.quickstart.framework.personen;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoPerson {
	
	@MongoId
	private ObjectId id;

	private String vorname;

	private String nachname;

	private String email;

	private LocalDate geburtsdatum;

}
