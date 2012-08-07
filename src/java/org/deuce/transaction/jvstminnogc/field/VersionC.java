package org.deuce.transaction.jvstminnogc.field;

import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class VersionC extends Version {
	public char value;

	public VersionC(int version, char value, Version next) {
		super(version, next);
		this.value = value;
	}
	
}