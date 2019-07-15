package com.codenvy.example.spring.daos;

import com.codenvy.example.spring.models.Produto;
import com.codenvy.example.spring.daos.ProdutoDAO$1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDAO {
	public ProdutoDAO() {
	}

	public void gravar(Produto produto) {
        System.out.println("ProdutoDAO.gravar [2]");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("alura-spring");
        DatabaseReference usersRef = ref.child("produtos");
        usersRef.child(produto.getTitulo()).setValue((Object)produto);
    }

	public List<Produto> listar() {
		List<Produto> listProd = new ArrayList<Produto>();

		FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference("alura-spring/produtos");

		Semaphore semaphore = new Semaphore(0);

		//ref.addValueEventListener(new ProdutoDAO$1(this, listProd, semaphore));
		ref.addValueEventListener(new ProdutoDAO$1(listProd, semaphore));
		
		/*
		 * ref.addValueEventListener(new ValueEventListener() { final synthetic List
		 * val$listProd; final synthetic Semaphore val$semaphore;
		 * 
		 * public void onDataChange(DataSnapshot dataSnapshot) { Iterable
		 * snapshotIterator = dataSnapshot.getChildren(); Iterator iterator =
		 * snapshotIterator.iterator(); while (iterator.hasNext()) { Produto prod =
		 * (Produto)((DataSnapshot)iterator.next()).getValue(Produto.class);
		 * System.out.println(prod.toString()); this.val$listProd.add(prod); }
		 * System.out.println("semaphore.release()"); this.val$semaphore.release(); }
		 * 
		 * public void onCancelled(DatabaseError arg0) { } });
		 */
		try {
			System.out.println("semaphore.acquire [2]");
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return listProd;
	}
}
