package com.khairayoub.Service;

import java.util.HashMap;
import java.util.Map;

import com.khairayoub.Produit;

public class ProduitService {
    public Map<Long, Produit> produits = new HashMap<>();

     public void ajouterProduit(Produit produit) {
        if (produits.containsKey(produit.getId()) || produits.containsValue(produit)) {
            throw new RuntimeException("Le produit existe déjà");
        }
        verifierDonneesProduit(produit);
        produits.put(produit.getId(), produit);
    }
    private void verifierDonneesProduit(Produit produit) {
        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Prix et quantité doivent être positifs");
        }
    }


    public Produit getProduit(Long id) {
        return produits.get(id);
    }



    public void supprimerProduit(Long id) {
        if (!produits.containsKey(id)) {
            throw new RuntimeException("Le produit à supprimer n'existe pas");
        }
        produits.remove(id);
    }
    public void mettreAJourProduit(Long id, Produit produit) {
        verifierDonneesProduit(produit);
        if (!produits.containsKey(id)) {
            throw new RuntimeException("Le produit n'existe pas");
        }
        produits.put(id, produit);

    }
}
