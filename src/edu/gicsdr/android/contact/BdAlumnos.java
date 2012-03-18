package edu.gicsdr.android.contact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BdAlumnos extends SQLiteOpenHelper {

	String sqlCrearBd = "CREATE TABLE persona(id  integer primary key, nombres TEXT, appaterno TEXT, apmaterno TEXT)";

	public BdAlumnos(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sqlCrearBd);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS persona");

		db.execSQL(sqlCrearBd);
	}

}
