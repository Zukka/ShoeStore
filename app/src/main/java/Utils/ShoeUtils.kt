package Utils

import com.udacity.shoestore.models.Shoe

class ShoeUtils {
    companion object {
        fun isShoeValid(shoe: Shoe) : Boolean {
            return nameIsValid(shoe) && sizeIsValid(shoe) && companyIsValid(shoe) && descIsValid(shoe)
        }

        private fun nameIsValid(shoe: Shoe): Boolean {
            return (shoe.name.isNotEmpty() && shoe.name.isNotBlank())
        }

        private fun sizeIsValid(shoe: Shoe): Boolean {
            return (shoe.size.isNotEmpty() && shoe.size.isNotBlank())
        }

        private fun companyIsValid(shoe: Shoe): Boolean {
            return (shoe.company.isNotEmpty() && shoe.company.isNotBlank())
        }

        private fun descIsValid(shoe: Shoe): Boolean {
            return (shoe.description.isNotEmpty() && shoe.description.isNotBlank())
        }
    }
}