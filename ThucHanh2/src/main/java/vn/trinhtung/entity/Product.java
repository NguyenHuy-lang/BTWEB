package vn.trinhtung.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product {
	@Pattern(regexp = "[0-9a-zA-Z]*", message = "Mã sản phẩm chỉ bao gồm chữ và số")
	@NotEmpty(message = "Mã sản phẩm không được để trống")
	@Id
	private String code;

	@NotEmpty(message = "Mô tả không được để trống")
	private String description;

	@NotNull(message = "Giá không được để trống")
	private double price;
}
