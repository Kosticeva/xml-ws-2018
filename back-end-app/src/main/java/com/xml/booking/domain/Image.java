package com.xml.booking.domain;

import javax.persistence.*;

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;

	@Lob
	@Column(nullable = false)
	protected String image;

	public Image() {
	}

	public Image(String base64image) {
		this.image = base64image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
