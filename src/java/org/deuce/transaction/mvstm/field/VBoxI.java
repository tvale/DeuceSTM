package org.deuce.transaction.mvstm.field;

import org.deuce.transform.ExcludeInternal;

/**
 * 
 * @author Ricardo Dias <ricardo.dias@campus.fct.unl.pt>
 */
@ExcludeInternal
public interface VBoxI extends VBox {

	void commit(int value, int txNumber);

}
