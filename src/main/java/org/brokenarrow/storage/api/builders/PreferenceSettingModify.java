package org.brokenarrow.storage.api.builders;

import org.brokenarrow.storage.api.util.sign.PlacingSignMode;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

public class PreferenceSettingModify {

    private final PreferenceSettingsDataAPIBuilder builder;
    
    public PreferenceSettingModify(final PreferenceSettingsDataAPI preferenceSettingsData) {
        this.builder = preferenceSettingsData.getBuilder();
    }
    
    public boolean isShowHologramsOnPlacedContainer() {
        return this.builder.isShowHologramsOnPlacedContainer();
    }

    public PreferenceSettingModify setShowHologramsOnPlacedContainer(final boolean showHologramsOnPlacedContainer) {
        this.builder.setShowHologramsOnPlacedContainer(showHologramsOnPlacedContainer);
        return this;
    }
    
    public boolean isShowEffectsWhenCraftItems() {
        return this.builder.isShowEffectsWhenCraftItems();
    }
    
    
    public PreferenceSettingModify setShowEffectsWhenCraftItems(final boolean showEffectsWhenCraftItems) {
        this.builder.setShowEffectsWhenCrafItems(showEffectsWhenCraftItems);
        return this;
    }
    
    public boolean isShowEffectsWhenSellItems() {
        return this.builder.isShowEffectsWhenSellItems();
    }
    
    public PreferenceSettingModify setShowEffectsWhenSellItems(final boolean showEffectsWhenSellItems) {
        this.builder.setShowEffectsWhenSellItems(showEffectsWhenSellItems);
        return this;
    }
    
    public boolean isSoundEffectsWhenCraftItems() {
        return this.builder.isSoundEffectsWhenCraftItems();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenCraftItems(final boolean soundEffectsWhenCraftItems) {
        this.builder.setShowEffectsWhenCrafItems(soundEffectsWhenCraftItems);
        return this;
    }
    
    public boolean isSoundEffectsWhenSellItems() {
        return this.builder.isSoundEffectsWhenSellItems();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenSellItems(final boolean soundEffectsWhenSellItems) {
        this.builder.setSoundEffectsWhenSellItems(soundEffectsWhenSellItems);
        return this;
    }
    
    public boolean isSoundEffectsWhenOpenClose() {
        return this.builder.isSoundEffectsWhenOpenClose();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenOpenClose(final boolean soundEffectsWhenOpenClose) {
        this.builder.setSoundEffectsWhenOpenClose(soundEffectsWhenOpenClose);
        return this;
    }
    
    public boolean isSoundEffectsWhenPlaceContainer() {
        return this.builder.isSoundEffectsWhenPlaceContainer();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenPlaceContainer(final boolean soundEffectsWhenPlaceContainer) {
        this.builder.setSoundEffectsWhenPlaceContainer(soundEffectsWhenPlaceContainer);
        return this;
    }


    public boolean isSoundEffectsWhenContainerPickUpItems() {
        return this.builder.isSoundEffectsWhenContainerPickUpItems();
    }
    
    
    public PreferenceSettingModify setSoundEffectsWhenContainerPickUpItems(final boolean soundEffectsWhenContainerPickUpItems) {
        this.builder.setSoundEffectsWhenContainerPickUpItems(soundEffectsWhenContainerPickUpItems);
        return this;
    }
    
    public boolean isDisplayPlayerNameOnHolo() {
        return this.builder.isDisplayPlayerNameOnHolo();
    }
    
    
    public PreferenceSettingModify setDisplayPlayerNameOnHolo(final boolean displayPlayerNameOnHolo) {
        this.builder.setDisplayPlayerNameOnHolo(displayPlayerNameOnHolo);
        return this;
    }
    
    public boolean isShowBorderSuctionWhenPlaceContainer() {
        return this.builder.isShowBorderSuctionWhenPlaceContainer();
    }
    
    
    public PreferenceSettingModify setShowBorderSuctionWhenPlaceContainer(final boolean showBorderSuctionWhenPlaceContainer) {
        this.builder.setShowBorderSuctionWhenPlaceContainer(showBorderSuctionWhenPlaceContainer);
        return this;
    }
    
    public boolean isHasLinkModeActiveTimeOrWhenTurnOf() {
        return this.builder.isHasLinkModeActiveTimeOrWhenTurnOf();
    }
    
    
    public PreferenceSettingModify setHasLinkModeActiveTimeOrWhenTurnOf(final boolean hasLinkModeActiveTimeOrWhenTurnOf) {
        this.builder.setHasLinkModeActiveTimeOrTurnOfAuto(hasLinkModeActiveTimeOrWhenTurnOf);
        return this;
    }
    
    public boolean isEffectOnContainer() {
        return this.builder.isEffectOnContainer();
    }
    
    
    public PreferenceSettingModify setEffectOnContainer(final boolean effectOnContainer) {
        this.builder.setEffectOnContainer(effectOnContainer);
        return this;
    }
    
    public boolean isEffectOnContainerWhenPlaceContainer() {
        return this.builder.isEffectOnContainerWhenPlaceContainer();
    }
    
    
    public PreferenceSettingModify setEffectOnContainerWhenPlaceContainer(final boolean effectOnContainerWhenPlaceContainer) {
        this.builder.setSoundEffectsWhenPlaceContainer(effectOnContainerWhenPlaceContainer);
        return this;
    }
    
    public boolean isShowNotesMessage() {
        return this.builder.isShowNotesMessage();
    }
    
    
    public PreferenceSettingModify setShowNotesMessage(final boolean showNotesMessage) {
        this.builder.setShowNotesMessage(showNotesMessage);
        return this;
    }
    
    public List<UUID> getPartyListOfPlayers() {
        return this.builder.getPartyListOfPlayers();
    }
    
    
    public PreferenceSettingModify setPartyListOfPlayers(@Nonnull final List<UUID> partyListOfPlayers) {
        this.builder.setPartyListOfPlayers(partyListOfPlayers);
        return this;
    }
    
    public PlacingSignMode getPlacingSignMode() {
        return this.builder.getPlacingSignMode();
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
