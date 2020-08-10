package com.myride.common.utils;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.myride.common.constants.CabType;

@Converter(autoApply = true)
public class CabTypeConverter implements AttributeConverter<CabType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(CabType cabType) {
		if (cabType == null) {
			return null;
		}
		return cabType.getCode();
	}

	@Override
	public CabType convertToEntityAttribute(Integer code) {
		if (code == null) {
			return null;
		}
		return Stream.of(CabType.values()).filter(c -> c.getCode().equals(code)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}