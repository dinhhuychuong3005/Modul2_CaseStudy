package Product;

import Filecsv.EmployeeFile;
import Filecsv.ProductFile;
import javafx.scene.transform.Scale;

import java.io.IOException;
import java.util.*;

public class ManageProduct {
    Scanner scanner = new Scanner(System.in);
    private List<Product> productList = new ArrayList<>();

    public ManageProduct() {
        try {
            this.productList = ProductFile.readFromFile("Product.csv");
        } catch (IOException e) {
            this.productList = new ArrayList<>();
        }
    }

    public ManageProduct(List<Product> productList) {
        this.productList = new ArrayList<Product>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public int searchID(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getMaSp())) {
                return i;
            }
        }
        return -1;
    }

    public void editIdById() {
        System.out.println("Nhập vào mã sản phẩm cần sửa");
        String id = scanner.nextLine();
        if (searchID(id) == -1) {
            System.out.println("Mã sản phẩm không tồn tại!");
        } else {
            Product product = new Product();
            product = InOutPutProduct.inputProduct();
            if ((productList.get(searchID(id)).getBrand()).equals("Vinamilk")) {
                product.setBrand("Vinamilk");
            } else if ((productList.get(searchID(id)).getBrand()).equals("Dutch Lady")) {
                product.setBrand("Dutch Lady");
            } else if ((productList.get(searchID(id)).getBrand()).equals("Nutifood")) {
                product.setBrand("Nutifood");
            }
            productList.set(searchID(id), product);
            try {
                ProductFile.writeToFile("Product.csv", productList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteById() {
        System.out.println("Nhập vào mã sản phẩm cần xóa");
        String id = scanner.nextLine();
        if (searchID(id) == -1) {
            System.out.println("Mã sản phẩm không tồn tại");
        } else {
            productList.remove(searchID(id));
            System.out.println("done!");
            System.out.println("Danh sách sản phẩm trong kho sau khi xóa là:");
            InOutPutProduct.outPut(productList);
            try {
                ProductFile.writeToFile("Product.csv", productList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Product> printVinamilk() {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getBrand().equals("Vinamilk")) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }

    public List<Product> printDutchLady() {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getBrand().equals("Dutch Lady")) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }

    public List<Product> printNutifood() {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getBrand().equals("Nutifood")) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }

    public void searchByBrand() {
        boolean isMenu = true;
        while (isMenu) {
            System.out.println("Nhập vào hãng sản phẩm cần tìm");
            System.out.println("1.Vinamilk \t 2.Dutch Lady \t 3.Nutifood \t 0.Trở về menu chính");
            int b = scanner.nextInt();
            switch (b) {
                case 1: {
                    List<Product> productList1 = printVinamilk();
                    if (productList1 == null) {
                        System.out.println("Không có sản phẩm nào thuộc hãng vinamilk");
                    } else {
                        InOutPutProduct.outPut(productList1);
                    }
                    break;
                }
                case 2: {
                    List<Product> productList1 = printDutchLady();
                    if (productList1 == null) {
                        System.out.println("Không có sản phẩm nào thuộc hãng Dutch Lady");
                    } else {
                        InOutPutProduct.outPut(productList1);
                    }
                    break;
                }
                case 3: {
                    List<Product> productList1 = printNutifood();
                    if (productList1 == null) {
                        System.out.println("Không có sản phẩm nào thuộc hãng Nutifood");
                    } else {
                        InOutPutProduct.outPut(productList1);
                    }
                    break;
                }
                case 0: {
                    isMenu = false;
                    break;
                }
            }
            break;
        }
    }
    public List<Product> searchByPrice(){
        List<Product> list = new ArrayList<>();
        System.out.println("Nhập vào khoảng giá cần tìm");
        System.out.println("Khoảng từ:");
        Double min = scanner.nextDouble();
        System.out.println("đến:");
        Double max = scanner.nextDouble();
        scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() >= min && productList.get(i).getPrice() <= max){
                list.add(productList.get(i));
            }
        }
        return list;
    }
public void sortPrice(){
    Collections.sort(productList, new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            int i = (int) (o1.getPrice() - o2.getPrice());
            if (i == 0){
                return o1.getName().compareTo(o2.getName());
            }
            return i;
        }
    });
}
}
