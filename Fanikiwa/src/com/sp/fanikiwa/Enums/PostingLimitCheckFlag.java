package com.sp.fanikiwa.Enums;

public enum PostingLimitCheckFlag {
	CheckLimitPassFlag(0), // Checks account limit status and PassFlag
	CheckLimitFlagOnly(1), // Checks account limit status and not PassFlag
	NoLimitCheck(2), // does not check limit but checks PassFlag
	ForcePost(3); // Will not check the limit as well as PassFlag. Equivalent to
					// Transaction.ForcePost
	private int value;

	private PostingLimitCheckFlag(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
