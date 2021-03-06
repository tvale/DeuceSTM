package org.deuce.transaction.lsacm.cm;

import org.deuce.transform.ExcludeInternal;
import org.deuce.transaction.lsacm.Context;
import org.deuce.transaction.lsacm.ContentionManager;

/**
 * @author Pascal Felber
 */
@ExcludeInternal
public class Aggressive implements ContentionManager {

	public int arbitrate(Context me, Context other, ConflictType type) {
		return KILL_OTHER;
	}
}
