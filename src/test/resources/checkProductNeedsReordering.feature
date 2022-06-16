Feature: Check product needs re-ordering

  Scenario Outline: Product needs re-ordering
    Given stock level is greater than buffer
    When The product is purchased in a quantity that lowers the stock level to or below the buffer
    Then A notification is sent to the store manager to order more product

    Examples: of products
      | product | stock level | buffer  | quantity  | notification  |
      | 811     | 37          | 20      | 17        | "Please order more of product 811: 'Epiphone Les Paul Classic In Worn Heritage Cherry Sunburst'" |



