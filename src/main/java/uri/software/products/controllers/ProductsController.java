package uri.software.products.controllers;

import uri.software.products.models.Product;
import uri.software.products.repository.ProductsRepository;

import java.util.ArrayList;

public class ProductsController {
    ProductsRepository repository;

    public ProductsController(ProductsRepository repository) {
        this.repository = repository;
    }

    public void create(
        String name,
        String description,
        float value,
        String unit,
        Integer category_id
    ) {
        if (name == null || name.trim().isEmpty()) {
            showMessage("Nome do produto é obrigatório.");
            return;
        }

        if (value <= 0) {
            showMessage("O valor precisa ser um número inteiro positivo.");
            return;
        }

        try {
            repository.store(name, description, value, unit, category_id);
            showMessage("Produto criado com sucesso.");
        } catch (Exception e) {
            showMessage("Erro ao criar produto: " + e.getMessage());
        }
    }

    public ArrayList<Product> list() {
        return repository.list();
    }

    private void showMessage(String message) {
    }
}
