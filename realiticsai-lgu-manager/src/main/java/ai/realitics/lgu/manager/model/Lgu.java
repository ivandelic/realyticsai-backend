package ai.realitics.lgu.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "readLgu", query = "select L from Lgu L where L.id = :id")
@NamedQuery(name = "listLgus", query = "select L from Lgu L where L.archived = false order by L.created desc")
public class Lgu extends LguEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private LguStatus status;

	@Column
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	private LguCounty lguCounty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LguStatus getStatus() {
		return status;
	}

	public void setStatus(LguStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LguCounty getLguCounty() {
		return lguCounty;
	}

	public void setLguCounty(LguCounty lguCounty) {
		this.lguCounty = lguCounty;
	}
}
