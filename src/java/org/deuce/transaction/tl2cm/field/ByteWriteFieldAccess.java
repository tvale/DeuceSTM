package org.deuce.transaction.tl2cm.field;

import org.deuce.reflection.UnsafeHolder;
import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class ByteWriteFieldAccess extends WriteFieldAccess {

	private byte value;

	public void set(byte value, Object reference, long field) {
		super.init(reference, field);
		this.value = value;
	}

	@Override
	public void put() {
		UnsafeHolder.getUnsafe().putByte(reference, field, value);
		clear();
	}

	public byte getValue() {
		return value;
	}

}
