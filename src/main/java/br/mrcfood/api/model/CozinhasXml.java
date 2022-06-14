package br.mrcfood.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import br.mrcfood.domain.entity.Cozinha;
import lombok.Data;
import lombok.NonNull;

/**
 * 	Esta classe é o pacote (lista)
 *  e a lista é tratada como um componente solo
 *  useWrapping = false é para desativar o list e tratar como objeto
 */


@JsonRootName(value = "cozinhas")
@Data
public class CozinhasXml {
	
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull
	private List<Cozinha> cozinhas;

}
