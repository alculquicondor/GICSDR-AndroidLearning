package com.firecoders.gics.android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MP_Persona {
	public static String sqlInsert(Persona persona)
	{
		return "INSERT INTO persona (nombres, appaterno, apmaterno) VALUES ('" + persona.getNombres() + "', '" + persona.getAppaterno() + "', '" + persona.getApmaterno() + "')" ;
	}
	public static String sqlUpdate(Persona persona)
	{
		return "UPDATE persona WHERE id = " + String.valueOf(persona.getId());
	}
	public static String sqlDelete(Persona persona)
	{
		return "DELETE FROM persona WHERE id = " + String.valueOf(persona.getId());
	}
	public static String sqlGetAll()
	{
		return "SELECT * FROM persona" ;
	}
	public static String sqlGetById(Integer id)
	{
		return "SELECT * FROM persona WHERE id = " + id.toString();
	}

	public static Contactos loadFromDb(Context context)
	{
		Contactos c = new Contactos();

		BdAlumnos bda = new BdAlumnos(context, "BdAlumnos", null, 3);
		
		SQLiteDatabase db = bda.getWritableDatabase();
		if(db != null)
		{
			
			Cursor cursor = db.rawQuery(MP_Persona.sqlGetAll(), new String[]{});
			if(cursor.moveToFirst())
			{
				do
				{
					Integer _id = cursor.getInt(0);
					String _nombres = cursor.getString(1);
					String _appaterno = cursor.getString(2);
					String _apmaterno = cursor.getString(3);
				
					Persona p = new Persona(_id, _nombres, _appaterno, _apmaterno);
					c.agregarPersona(p);	
					
				}while(cursor.moveToNext());				
			}			
		}	
		return c;
	}

	
	public static Contactos getById(Context context, Integer id)
	{
		Contactos c = new Contactos();

		BdAlumnos bda = new BdAlumnos(context, "BdAlumnos", null, 3);
		
		SQLiteDatabase db = bda.getWritableDatabase();
		if(db != null)
		{
			
			Cursor cursor = db.rawQuery(MP_Persona.sqlGetById(id), new String[]{});
			if(cursor.moveToFirst())
			{
				do
				{
					Integer _id = cursor.getInt(0);
					String _nombres = cursor.getString(1);
					String _appaterno = cursor.getString(2);
					String _apmaterno = cursor.getString(3);
				
					Persona p = new Persona(_id, _nombres, _appaterno, _apmaterno);
					c.agregarPersona(p);	
					
				}while(cursor.moveToNext());				
			}			
		}	
		return c;
	}

	public static void eliminarPersona(Context context, Persona persona)
	{
		BdAlumnos bda = new BdAlumnos(context, "BdAlumnos", null, 3);
		
		SQLiteDatabase db = bda.getWritableDatabase();
		if(db != null)
		{
			db.execSQL(MP_Persona.sqlDelete(persona));
		}		
	}
	
	public static void actualizarPersona(Context context, Persona persona)
	{
		BdAlumnos bda = new BdAlumnos(context, "BdAlumnos", null, 3);
		
		SQLiteDatabase db = bda.getWritableDatabase();
		if(db != null)
		{
			db.execSQL(MP_Persona.sqlUpdate(persona));
		}		
	}
}
