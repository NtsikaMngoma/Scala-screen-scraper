package com.tesobe.obp_importer.model

/**
 * Holds the configuration of an account.
 *
 * @param bank the bank code of this account (e.g. "10010010" for Postbank)
 * @param account the account number of this account (e.g. "12345")
 * @param pinData the encrypted PIN for this account
 */
case class AccountConfig(
  holder: String,
  username: String,
  bank: String,
  account: String,
  pindata: String
) {
  def toShortString = "AccountConfig(" + holder + ", " + bank + ", " + account + ", ...)"
}

/**
 * Holds the transaction data that is to be pushed to the OBP API.
 */
case class OBPTransactionWrapper(
  obp_transaction: OBPTransaction)

case class OBPTransaction(
  this_account: OBPAccount,
  other_account: OBPAccount,
  details: OBPDetails)

case class OBPAccount(
  holder: String,
  number: String,
  kind: String,
  bank: OBPBank)

//IBAN is in here rather than the OBPAccount for legacy reasons
case class OBPBank(
  IBAN: String,
  national_identifier: String,
  name: String)

case class OBPDetails(
  kind: String,
  posted: OBPDate,
  completed: OBPDate,
  new_balance: OBPAmount,
  value: OBPAmount,
  label: String)

case class OBPDate(`$dt`: String)

case class OBPAmount(
  currency: String,
  amount: String) {
  override def toString = "OBPAmount(" + currency + ",***)"
}

