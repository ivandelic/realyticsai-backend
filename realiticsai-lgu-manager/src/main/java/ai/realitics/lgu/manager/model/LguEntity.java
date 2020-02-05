package ai.realitics.lgu.manager.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class LguEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	private Timestamp vesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(nullable = false)
	private boolean archived = false;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public Timestamp getVesion() {
		return vesion;
	}

	public Date getCreated() {
		return created;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

}