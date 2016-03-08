package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Paise;

@Component
@Transactional
public class PaiseToStringConverter implements Converter<Paise, String> {

	@Override
	public String convert(Paise paise) {
		String result;

		if (paise == null)
			result = null;
		else
			result = String.valueOf(paise.getId());

		return result;
	}

}
