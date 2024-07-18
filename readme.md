# Shipping Cost Calculator

This JavaScript application calculates the optimal shipping method and cost for products shipped from China to Germany using predefined product details and container options.

## Project Overview

The application handles the shipping of various products with specific dimensions and weights. The products available for shipping are:

1.  **Laptop**

    - Box size: 60x50x50 cm
    - Weight: 6.5 kg

2.  **Mouse**

    - Box size: 30x30x20 cm
    - Weight: 200 g

3.  **Desktop**

    - Box size: 100x150x50 cm
    - Weight: 20 kg

4.  **LCD screens**

    - Box size: 120x140x80 cm
    - Weight: 2.6 kg

The shipping options include:

- **Small Container**

  - Dimensions: 2.59m height, 2.43m wide, 6.06m length
  - Cost: €1000 (≤500 kg), €1200 (>500 kg)

- **Big Container**

  - Dimensions: 2.59m height, 2.43m wide, 12.01m length
  - Cost: €1800 (fixed)

## Functionality

- **Input**: Users input the quantity of each product type they want to ship (e.g., 100Lap, 200 Mouse, 150 Desktop, 200 LCD screen).
- **Calculation**: The program computes the optimal shipping method based on cost efficiency:

  - Determines the total weight and volume of the shipment.
  - Chooses between using one or more big containers or a combination of big and small containers based on minimizing costs.

- **Output**: Displays the recommended shipping method(s) and associated costs.

## Usage

1.  **Setup**:

    - Ensure you have Node.js installed on your machine.

2.  **Run the Program**:

    - Clone this repository.
    - Navigate to the project directory in your terminal.
    - Run `node shipping_calculator.js` to execute the program.

3.  **Input Example**:

```
100 Lap, 200 Mouse, 150 Desktop, 200 LCD screen
```

1.  Enter quantities for each product type separated by commas.

## Technologies Used

- Java

## Author

- Taha Al-Hadhary

## License

This project is licensed under the MIT License. See the LICENSE file for details.
