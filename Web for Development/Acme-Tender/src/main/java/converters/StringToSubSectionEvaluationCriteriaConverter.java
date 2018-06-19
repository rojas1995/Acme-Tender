
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.SubSectionEvaluationCriteria;
import repositories.SubSectionEvaluationCriteriaRepository;

@Component
@Transactional
public class StringToSubSectionEvaluationCriteriaConverter implements Converter<String, SubSectionEvaluationCriteria> {

	@Autowired
	SubSectionEvaluationCriteriaRepository repository;


	@Override
	public SubSectionEvaluationCriteria convert(final String text) {
		SubSectionEvaluationCriteria result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {			
				id = Integer.valueOf(text);
				result = this.repository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}
}
