package edu.gicsdr.android.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {
	private EditText txtNombres;
	private EditText txtAppaterno;
	private EditText txtApmaterno;

	private Button btnAnterior;
	private Button btnSiguiente;
	private Button btnEliminar;

	private Contactos m_contactos;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txtNombres = (EditText) this.findViewById(R.id.txtNombres);
		txtAppaterno = (EditText) this.findViewById(R.id.txtAppaterno);
		txtApmaterno = (EditText) this.findViewById(R.id.txtApmaterno);

		btnAnterior = (Button) this.findViewById(R.id.btnAnterior);
		btnSiguiente = (Button) this.findViewById(R.id.btnSiguiente);
		btnEliminar = (Button) this.findViewById(R.id.btnEliminar);

		loadData();
		pintarPersona();

		btnAnterior.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m_contactos.anteriorContacto();
				pintarPersona();
			}
		});

		btnSiguiente.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m_contactos.siguienteContacto();
				pintarPersona();

			}
		});

		btnEliminar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MP_Persona.eliminarPersona(v.getContext(),
						m_contactos.contactoActual());
				loadData();
				pintarPersona();
			}
		});
	}

	public void pintarPersona() {
		if (this.m_contactos.getContactos().size() > 0) {
			this.txtNombres.setText(m_contactos.contactoActual().getNombres());
			this.txtAppaterno.setText(m_contactos.contactoActual()
					.getAppaterno());
			this.txtApmaterno.setText(m_contactos.contactoActual()
					.getApmaterno());
		}
	}

	public void loadData() {
		m_contactos = MP_Persona.loadFromDb(this);
		// Contactos.cargarBD(this);

	}

}