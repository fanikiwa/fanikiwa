package com.sp.fanikiwa.business.messaging;

import java.util.Date;


public abstract class Message
{
    /// <summary>
    /// Gets or sets a messageDate.
    /// </summary>
    Date messageDate;

    /// <summary>
    /// Gets or sets addressFrom.
    /// </summary>
    String addressFrom;

    /// <summary>
    /// Gets or sets addressTo.
    /// </summary>
    String addressTo ;

    Object Body ;
}