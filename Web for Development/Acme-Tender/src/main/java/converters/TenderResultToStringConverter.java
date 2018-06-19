
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.TenderResult;

@Component
@Transactional
public class TenderResultToStringConverter implements Converter<TenderResult, String> {

	@Override
	public String convert(final TenderResult data) {
		String result;

		if (data == null)
			result = null;
		else
			result = String.valueOf(data.getId());

		return result;
	}

}
