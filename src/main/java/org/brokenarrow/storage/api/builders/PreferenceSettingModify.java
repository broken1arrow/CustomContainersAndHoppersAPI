package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.util.sign.PlacingSignMode;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

public class PreferenceSettingModify {
    
    private final PreferenceSettingsDataAPI preferenceSettingsData;
    private final PreferenceSettingsDataAPIBuilder builder;
    
    public PreferenceSettingModify(PreferenceSettingsDataAPI preferenceSettingsData) {
        this.preferenceSettingsData = preferenceSettingsData;
        this.builder = preferenceSettingsData.getBuilder();
    }
    
    public boolean isShowHologramsOnPlacedContainer() {
        return preferenceSettingsData.isShowHologramsOnPlacedContainer();
    }
    
    
    public PreferenceSettingModify setShowHologramsOnPlacedContainer(final boolean showHologramsOnPlacedContainer) {
        this.builder.setShowHologramsOnPlacedContainer(showHologramsOnPlacedContainer);
        return this;
    }
    
    public boolean isShowEffectsWhenCraftItems() {
        return preferenceSettingsData.isShowEffectsWhenCrafItems();
    }
    
    
    public PreferenceSettingModify setShowEffectsWhenCraftItems(final boolean showEffectsWhenCraftItems) {
        this.builder.setShowEffectsWhenCrafItems(showEffectsWhenCraftItems);
        return this;
    }
    
    public boolean isShowEffectsWhenSellItems() {
        return preferenceSettingsData.isShowEffectsWhenSellItems();
    }
    
    public PreferenceSettingModify setShowEffectsWhenSellItems(final boolean showEffectsWhenSellItems) {
        this.builder.setShowEffectsWhenSellItems(showEffectsWhenSellItems);
        return this;
    }
    
    public boolean isSoundEffectsWhenCraftItems() {
        return preferenceSettingsData.isSoundEffectsWhenCrafItems();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenCraftItems(final boolean soundEffectsWhenCraftItems) {
        this.builder.setShowEffectsWhenCrafItems(soundEffectsWhenCraftItems);
        return this;
    }
    
    public boolean isSoundEffectsWhenSellItems() {
        return preferenceSettingsData.isSoundEffectsWhenSellItems();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenSellItems(final boolean soundEffectsWhenSellItems) {
        this.builder.setSoundEffectsWhenSellItems(soundEffectsWhenSellItems);
        return this;
    }
    
    public boolean isSoundEffectsWhenOpenClose() {
        return preferenceSettingsData.isSoundEffectsWhenOpenClose();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenOpenClose(final boolean soundEffectsWhenOpenClose) {
        this.builder.setSoundEffectsWhenOpenClose(soundEffectsWhenOpenClose);
        return this;
    }
    
    public boolean isSoundEffectsWhenPlaceContainer() {
        return this.preferenceSettingsData.isShowBorderSuctionWhenPlaceContainer();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenPlaceContainer(final boolean soundEffectsWhenPlaceContainer) {
        this.builder.setSoundEffectsWhenPlaceContainer(soundEffectsWhenPlaceContainer);
        return this;
    }
    
    public boolean isSoundEffectsWhenContainerPickUpItems() {
        return this.preferenceSettingsData.isSoundEffectsWhenContainerPickUpItems();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenContainerPickUpItems(final boolean soundEffectsWhenContainerPickUpItems) {
        this.builder.setSoundEffectsWhenContainerPickUpItems(soundEffectsWhenContainerPickUpItems);
        return this;
    }
    
    public boolean isDisplayPlayerNameOnHolo() {
        return this.preferenceSettingsData.isDisplayPlayerNameOnHolo();
    }
    
    
    public PreferenceSettingModify setDisplayPlayerNameOnHolo(final boolean displayPlayerNameOnHolo) {
        this.builder.setDisplayPlayerNameOnHolo(displayPlayerNameOnHolo);
        return this;
    }
    
    public boolean isShowBorderSuctionWhenPlaceContainer() {
        return this.preferenceSettingsData.isShowBorderSuctionWhenPlaceContainer();
    }
    
    
    public PreferenceSettingModify setShowBorderSuctionWhenPlaceContainer(final boolean showBorderSuctionWhenPlaceContainer) {
        this.builder.setShowBorderSuctionWhenPlaceContainer(showBorderSuctionWhenPlaceContainer);
        return this;
    }
    
    public boolean isHasLinkModeActiveTimeOrWhenTurnOf() {
        return this.preferenceSettingsData.isHasLinkModeActiveTimeOrWhenTurnOf();
    }
    
    
    public PreferenceSettingModify setHasLinkModeActiveTimeOrWhenTurnOf(final boolean hasLinkModeActiveTimeOrWhenTurnOf) {
        this.builder.setHasLinkModeActiveTimeOrTurnOfAuto(hasLinkModeActiveTimeOrWhenTurnOf);
        return this;
    }
    
    public boolean isEffectOnContainer() {
        return this.preferenceSettingsData.isEffectOnContainer();
    }
    
    
    public PreferenceSettingModify setEffectOnContainer(final boolean effectOnContainer) {
        this.builder.setEffectOnContainer(effectOnContainer);
        return this;
    }
    
    public boolean isEffectOnContainerWhenPlaceContainer() {
        return this.preferenceSettingsData.isEffectOnContainerWhenPlaceContainer();
    }
    
    
    public PreferenceSettingModify setEffectOnContainerWhenPlaceContainer(final boolean effectOnContainerWhenPlaceContainer) {
        this.builder.setSoundEffectsWhenPlaceContainer(effectOnContainerWhenPlaceContainer);
        return this;
    }
    
    public boolean isShowNotesMessage() {
        return this.preferenceSettingsData.isShowNotesMessage();
    }
    
    
    public PreferenceSettingModify setShowNotesMessage(final boolean showNotesMessage) {
        this.builder.setShowNotesMessage(showNotesMessage);
        return this;
    }
    
    public List<UUID> getPartyListOfPlayers() {
        return this.preferenceSettingsData.getPartyListOfPlayers();
    }
    
    
    public PreferenceSettingModify setPartyListOfPlayers(@Nonnull final List<UUID> partyListOfPlayers) {
        this.builder.setPartyListOfPlayers(partyListOfPlayers);
        return this;
    }
    
    public PlacingSignMode getPlacingSignMode() {
        return this.preferenceSettingsData.getPlacingSignMode();
    }
    
    
    public PreferenceSettingModify setPlacingSignMode(PlacingSignMode placingSignMode) {
        this.builder.setPlacingSignMode(placingSignMode);
        return this;
    }
    
    @Nonnull
    public PreferenceSettingsDataAPI apply() {
        return builder.build();
    }
    
}
