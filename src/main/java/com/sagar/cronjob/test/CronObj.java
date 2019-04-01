package com.sagar.cronjob.test;

import java.util.Date;

public class CronObj {
	
	String OfferId;
	String StoreId;
	String HostId;
	String DataCenter;
	String Cloud;
	String ErrorCode;
	String ConsumerId;
	Date TimeStamp;
	
	public CronObj(String offerId, String storeId, String hostId, String dataCenter, String cloud, String errorCode,
			String consumerId, Date timeStamp) {
		super();
		OfferId = offerId;
		StoreId = storeId;
		HostId = hostId;
		DataCenter = dataCenter;
		Cloud = cloud;
		ErrorCode = errorCode;
		ConsumerId = consumerId;
		TimeStamp = timeStamp;
	}

	public String getOfferId() {
		return OfferId;
	}

	public void setOfferId(String offerId) {
		OfferId = offerId;
	}

	public String getStoreId() {
		return StoreId;
	}

	public void setStoreId(String storeId) {
		StoreId = storeId;
	}

	public String getHostId() {
		return HostId;
	}

	public void setHostId(String hostId) {
		HostId = hostId;
	}

	public String getDataCenter() {
		return DataCenter;
	}

	public void setDataCenter(String dataCenter) {
		DataCenter = dataCenter;
	}

	public String getCloud() {
		return Cloud;
	}

	public void setCloud(String cloud) {
		Cloud = cloud;
	}

	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getConsumerId() {
		return ConsumerId;
	}

	public void setConsumerId(String consumerId) {
		ConsumerId = consumerId;
	}

	public Date getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "CronObj [OfferId=" + OfferId + ", StoreId=" + StoreId + ", HostId=" + HostId + ", DataCenter="
				+ DataCenter + ", Cloud=" + Cloud + ", ErrorCode=" + ErrorCode + ", ConsumerId=" + ConsumerId
				+ ", TimeStamp=" + TimeStamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cloud == null) ? 0 : Cloud.hashCode());
		result = prime * result + ((ConsumerId == null) ? 0 : ConsumerId.hashCode());
		result = prime * result + ((DataCenter == null) ? 0 : DataCenter.hashCode());
		result = prime * result + ((ErrorCode == null) ? 0 : ErrorCode.hashCode());
		result = prime * result + ((HostId == null) ? 0 : HostId.hashCode());
		result = prime * result + ((OfferId == null) ? 0 : OfferId.hashCode());
		result = prime * result + ((StoreId == null) ? 0 : StoreId.hashCode());
		result = prime * result + ((TimeStamp == null) ? 0 : TimeStamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CronObj other = (CronObj) obj;
		if (Cloud == null) {
			if (other.Cloud != null)
				return false;
		} else if (!Cloud.equals(other.Cloud))
			return false;
		if (ConsumerId == null) {
			if (other.ConsumerId != null)
				return false;
		} else if (!ConsumerId.equals(other.ConsumerId))
			return false;
		if (DataCenter == null) {
			if (other.DataCenter != null)
				return false;
		} else if (!DataCenter.equals(other.DataCenter))
			return false;
		if (ErrorCode == null) {
			if (other.ErrorCode != null)
				return false;
		} else if (!ErrorCode.equals(other.ErrorCode))
			return false;
		if (HostId == null) {
			if (other.HostId != null)
				return false;
		} else if (!HostId.equals(other.HostId))
			return false;
		if (OfferId == null) {
			if (other.OfferId != null)
				return false;
		} else if (!OfferId.equals(other.OfferId))
			return false;
		if (StoreId == null) {
			if (other.StoreId != null)
				return false;
		} else if (!StoreId.equals(other.StoreId))
			return false;
		if (TimeStamp == null) {
			if (other.TimeStamp != null)
				return false;
		} else if (!TimeStamp.equals(other.TimeStamp))
			return false;
		return true;
	}
	
	

}
