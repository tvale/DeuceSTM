/*
 * JVSTM: a Java library for Software Transactional Memory
 * Copyright (C) 2005 INESC-ID Software Engineering Group
 * http://www.esw.inesc-id.pt
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Author's contact:
 * INESC-ID Software Engineering Group
 * Rua Alves Redol 9
 * 1000 - 029 Lisboa
 * Portugal
 */
package org.deuce.transaction.jvstm.field;


import org.deuce.transform.ExcludeInternal;

@ExcludeInternal
public class VBoxSBody implements VBoxBody {

	public volatile int version;
	public VBoxSBody next;
	public volatile short value;

	public VBoxSBody(short value, int version, VBoxSBody next) {
		this.version = version;
		this.next = next;
		this.value = value;
	}

	public VBoxSBody getBody(int maxVersion) {
//		return ((version > maxVersion) ? next.getBody(maxVersion) : this);
		VBoxSBody res = this;
		while(res.version > maxVersion) { res = res.next; }
		return res;
	}

	public void clearPrevious() {
		this.next = null;
	}
}
