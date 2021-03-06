package org.deuce.transaction.tl2cm.field;

import org.deuce.reflection.UnsafeHolder;
import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class ShortWriteFieldAccess extends WriteFieldAccess {

	private short value;

	public void set(short value, Object reference, long field) {
		super.init(reference, field);
		this.value = value;
	}

	@Override
	public void put() {
		UnsafeHolder.getUnsafe().putShort(reference, field, value);
		clear();
	}

	public short getValue() {
		return value;
	}

}
