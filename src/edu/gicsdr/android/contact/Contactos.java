package edu.gicsdr.android.contact;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Contactos {
	private int m_indiceactual;
	private ArrayList<Persona> m_contactos;

	public int getIndiceactual() {
		return m_indiceactual;
	}

	public ArrayList<Persona> getContactos() {
		return m_contactos;
	}

	public Contactos() {
		m_indiceactual = 0;
		m_contactos = new ArrayList<Persona>();
	}

	public Persona contactoActual() {
		if (this.m_contactos.size() == 0) {
			return null;
		}
		return this.m_contactos.get(m_indiceactual);

	}

	public void siguienteContacto() {
		if (this.m_contactos.size() == 0) {
			return;
		}

		m_indiceactual++;
		m_indiceactual %= this.m_contactos.size();
	}

	public void anteriorContacto() {
		if (this.m_contactos.size() == 0) {
			return;
		}

		m_indiceactual = m_indiceactual + this.m_contactos.size() - 1;
		m_indiceactual %= this.m_contactos.size();
	}

	public void agregarPersona(Persona newPersona) {
		this.m_contactos.add(newPersona);
	}

	public static Contactos loadPersonasPrueba() {
		Contactos c = new Contactos();
		Persona p = new Persona(1, "Carlos", "Salvatierra", "Lucano");
		c.agregarPersona(p);
		p = new Persona(2, "Diego", "Lucano", "Salazar");
		c.agregarPersona(p);
		p = new Persona(3, "Kevin", "Diaz", "Figueroa");
		c.agregarPersona(p);

		return c;
	}

	public static void cargarBD(Context context) {
		BdAlumnos bda = new BdAlumnos(context, "BdAlumnos", null, 3);

		SQLiteDatabase db = bda.getWritableDatabase();
		if (db != null) {
			Contactos c = Contactos.loadPersonasPrueba();

			for (Iterator<Persona> iter = c.m_contactos.iterator(); iter
					.hasNext();) {
				db.execSQL(MP_Persona.sqlInsert(iter.next()));
			}
		}
	}

}
