package controller;

import Filecsv.ProductFile;
import model.product.InOutPutProduct;
import model.product.Product;
import service.ManageProduct;
import Validate.Validate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProduct {
    public static void mainProduct() {
        ProductFile productFile = new ProductFile();
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        ManageProduct manageProduct = new ManageProduct();
        while (check) {
            System.out.println("------ QUẢN LÝ KHO HÀNG ------");
            System.out.println("Mời bạn nhập lựa chọn theo số mục lục từ 0-8");
            System.out.println("1. Xem danh sách hàng hóa trong kho.");
            System.out.println("2. Thêm hàng hóa vào kho.");
            System.out.println("3. Chỉnh sửa thông tin hàng hóa.");
            System.out.println("4. Xóa hàng hóa.");
            System.out.println("5. Tìm kiếm theo mã hàng hóa.");
            System.out.println("6. Tìm kiếm theo hãng hàng hóa.");
            System.out.println("7. Tìm kiếm theo khoảng giá.");
            System.out.println("8. Xem tình trạng hàng hóa theo mã.");
            System.out.println("9. Xem tình trạng tất cả hàng hóa trong kho.");
            System.out.println("10. Sắp xếp hàng hóa theo giá và tên.");
            System.out.println("0. Thoát.");
            boolean isMenu = true;
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Danh sách sản phẩm trong kho:");
                    InOutPutProduct.outPut(manageProduct.getProductList());
                    break;
                }
                case 2: {
                    while (isMenu) {
                        System.out.println("1.Thêm vào hãng Vinamilk");
                        System.out.println("2.Thêm vào hãng Dutch Lady");
                        System.out.println("3.Thêm vào hãng Nutifood");
                        System.out.println("0.Quay về menu chính");
                        int pr = scanner.nextInt();
                        scanner.nextLine();
                        switch (pr) {
                            case 1: {
                                Product product = new Product();
                                product = InOutPutProduct.inputProduct();
                                System.out.println("Nhập vào mã sản phẩm theo định dạng VNMxxx");
                                String id;
                                do {
                                    id = scanner.nextLine();
                                    if ((!Validate.valid(id, Validate.VNM_REGEX)) || (manageProduct.searchID(id) != -1)) {
                                        System.out.println("Sai định dạng! Mời nhập lại");
                                    }
                                } while ((!Validate.valid(id, Validate.VNM_REGEX)) || (manageProduct.searchID(id) != -1));
                                product.setMaSp(id);
                                product.setBrand("Vinamilk");
                                manageProduct.add(product);
                                try {
                                    productFile.writeToFile("Product.csv", manageProduct.getProductList());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 2: {
                                Product product = new Product();
                                product = InOutPutProduct.inputProduct();
                                System.out.println("Nhập vào mã sản phẩm theo định dạng DLxxx");
                                String id;
                                do {
                                    id = scanner.nextLine();
                                    if ((!Validate.valid(id, Validate.DL_REGEX)) || (manageProduct.searchID(id) != -1)) {
                                        System.out.println("Sai định dạng! Mời nhập lại");
                                    }
                                } while ((!Validate.valid(id, Validate.DL_REGEX)) || (manageProduct.searchID(id) != -1));
                                product.setMaSp(id);
                                product.setBrand("Dutch Lady");
                                manageProduct.add(product);
                                try {
                                    productFile.writeToFile("Product.csv", manageProduct.getProductList());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 3: {
                                Product product = new Product();
                                product = InOutPutProduct.inputProduct();
                                System.out.println("Nhập vào mã sản phẩm theo định dạng NTFxxx");
                                String id;
                                do {
                                    id = scanner.nextLine();
                                    if ((!Validate.valid(id, Validate.NTF_REGEX)) || (manageProduct.searchID(id) != -1)) {
                                        System.out.println("Sai định dạng! Mời nhập lại");
                                    }
                                } while ((!Validate.valid(id, Validate.NTF_REGEX)) || (manageProduct.searchID(id) != -1));
                                product.setMaSp(id);
                                product.setBrand("Nutifood");
                                manageProduct.add(product);
                                try {
                                    productFile.writeToFile("Product.csv", manageProduct.getProductList());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 0: {
                                isMenu = false;
                                break;
                            }
                            default:
                                System.out.println("Mời nhập lại");
                                break;
                        }
                    }
                    break;
                }
                case 3: {
                    manageProduct.editIdById();
                    System.out.println("Danh sách sản phẩm sau khi sửa là");
                    InOutPutProduct.outPut(manageProduct.getProductList());
                    break;
                }
                case 4: {
                    manageProduct.deleteById();
                    break;
                }
                case 5: {
                    System.out.println("Nhập vào mã sản phẩm cần tìm");
                    String id = scanner.nextLine();
                    if (manageProduct.searchID(id) == -1) {
                        System.out.println("Mã sản phẩm không tồn tại");
                    } else {
                        System.out.println("Thông tin sản phẩm cần tìm là:");
                        System.out.println(manageProduct.getProductList().get(manageProduct.searchID(id)));
                    }
                    break;
                }
                case 6: {
                    manageProduct.searchByBrand();
                    break;
                }
                case 7: {
                    List<Product> list = manageProduct.searchByPrice();
                    if (list == null) {
                        System.out.println("Không có sản phẩm nào trong khoảng giá cần tìm");
                    } else {
                        System.out.println("Sản phẩm cần tìm là");
                        InOutPutProduct.outPut(list);
                    }
                    break;
                }
                case 8: {
                    System.out.println("Nhập vào mã hàng hóa cần xem");
                    String id = scanner.nextLine();
                    if (manageProduct.searchID(id) == -1) {
                        System.out.println("Mã sản phẩm không tồn tại");
                    } else {
                        System.out.println("Tình trạng sản phẩm cần kiểm tra là");
                        System.out.println(manageProduct.getProductList().get(manageProduct.searchID(id)).toStringAll());
                        if (manageProduct.getProductList().get(manageProduct.searchID(id)).getSoNgayConLai() <= 0) {
                            System.out.println("Sản phẩm đã hết hạn");
                        } else if ((manageProduct.getProductList().get(manageProduct.searchID(id)).getSoNgayConLai()) > 0 && (manageProduct.getProductList().get(manageProduct.searchID(id)).getSoNgayConLai() <= 7)) {
                            System.out.println("Sản phẩm sắp hết hạn");
                        } else {
                            System.out.println("Sản phẩm vẫn còn " + (manageProduct.getProductList().get(manageProduct.searchID(id)).getSoNgayConLai()) + " Ngày sử dụng");
                        }
                    }
                    break;
                }
                case 9: {
                   List<Product> list = manageProduct.checkStatus();
                    if (list.size() == 0) {
                        System.out.println("Không có sản phẩm nào hết hạn");
                    } else {
                        System.out.println("Danh sách sản phẩm hết hạn");
                        InOutPutProduct.outPutProduct(list);
                    }
                    break;
                }
                case 10: {
                    manageProduct.sortPrice();
                    System.out.println("Sau khi sắp xếp");
                    InOutPutProduct.outPut(manageProduct.getProductList());
                    try {
                        productFile.writeToFile("Product.csv", manageProduct.getProductList());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 0: {
                    check = false;
                    break;
                }
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }
}
