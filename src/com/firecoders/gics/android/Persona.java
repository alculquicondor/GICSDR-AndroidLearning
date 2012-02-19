package com.firecoders.gics.android;


public class Persona {
	private Integer m_id;
	private String m_nombres;
	private String m_appaterno;
	private String apmaterno;

	public Integer getId() {
		return m_id;
	}

	public void setId(Integer id) {
		this.m_id = id;
	}

	public String getNombres() {
		return m_nombres;
	}

	public void setNombres(String nombres) {
		this.m_nombres = nombres;
	}

	public String getAppaterno() {
		return m_appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.m_appaterno = appaterno;
	}

	public String getApmaterno() {
		return apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public Persona() {
		super();
		this.m_nombres = "";
		this.m_appaterno = "";
		this.apmaterno = "";
	}

	public Persona(Integer id, String m_nombres, String appaterno,
			String apmaterno) {
		super();
		this.m_id = id;
		this.m_nombres = m_nombres;
		this.m_appaterno = appaterno;
		this.apmaterno = apmaterno;
	}

	@Override
	public String toString() {
		return "Persona [m_id=" + m_id + ", m_nombres=" + m_nombres
				+ ", m_appaterno=" + m_appaterno + ", apmaterno=" + apmaterno
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apmaterno == null) ? 0 : apmaterno.hashCode());
		result = prime * result
				+ ((m_appaterno == null) ? 0 : m_appaterno.hashCode());
		result = prime * result + ((m_id == null) ? 0 : m_id.hashCode());
		result = prime * result
				+ ((m_nombres == null) ? 0 : m_nombres.hashCode());
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
		Persona other = (Persona) obj;
		if (apmaterno == null) {
			if (other.apmaterno != null)
				return false;
		} else if (!apmaterno.equals(other.apmaterno))
			return false;
		if (m_appaterno == null) {
			if (other.m_appaterno != null)
				return false;
		} else if (!m_appaterno.equals(other.m_appaterno))
			return false;
		if (m_id == null) {
			if (other.m_id != null)
				return false;
		} else if (!m_id.equals(other.m_id))
			return false;
		if (m_nombres == null) {
			if (other.m_nombres != null)
				return false;
		} else if (!m_nombres.equals(other.m_nombres))
			return false;
		return true;
	}

}
